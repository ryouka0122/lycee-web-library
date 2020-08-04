package net.coolblossom.lycee.app.web.controller

import net.coolblossom.lycee.app.web.entity.Author
import net.coolblossom.lycee.app.web.entity.Book
import net.coolblossom.lycee.app.web.entity.Publisher
import net.coolblossom.lycee.app.web.service.impl.BookServiceImpl
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultHandler
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification
import spock.lang.Unroll

import static org.hamcrest.Matchers.containsString
import static org.hamcrest.Matchers.not
import static org.springframework.test.web.servlet.ResultMatcher.matchAll
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@AutoConfigureMockMvc
@SpringBootTest
@Unroll
class SearchBookControllerSpec extends Specification {

    @Autowired
    MockMvc mockMvc

    @Autowired
    WebApplicationContext appContext

    @SpringBean
    BookServiceImpl bookServiceMock = Mock()

    def setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(appContext).build()
    }

    @Unroll
    def "test empty #descr" () {
        given:
        bookServiceMock.select(_ as String) >> Collections.emptyList()

        when:
        def request = MockMvcRequestBuilders.get("/search/")
        if (testcase.keyword != null) {
            request.param("keyword", testcase.keyword)
        }

        def result = mockMvc.perform(request)

        then:
        result.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(matchAll(*testcase.expected))

        where:
        testcase << [
                [
                        "descr": "null",
                        "keyword": null,
                        "expected": [
                                content().string(not(containsString("/search/detail/")))
                        ]
                ],
                [
                        "descr": "emptystring",
                        "keyword": "",
                        "expected": [
                                content().string(not(containsString("/search/detail/")))
                        ]
                ]
        ]
        descr = testcase.descr
    }

    @Unroll
    def "test result [#description]"() {
        given:
        bookServiceMock.select(_ as String) >> testcase.bookList

        when:
        def request = MockMvcRequestBuilders.get("/search/")
        if (testcase.keyword != null) {
            request.param("keyword", testcase.keyword)
        }

        def result = mockMvc.perform(request)

        then:
        result.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(matchAll(*testcase.expected))

        where:
        testcase << [
                [
                        "description": "many result",
                        "keyword": "猫",
                        "bookList": [
                                new Book(
                                        bookId: 1,
                                        bookName: "吾輩は猫である",
                                        author: new Author(authorId: 1, authorName: "夏目漱石"),
                                        publisher: new Publisher(publisherId: 1, publisherName: "ちくま文庫")
                                )
                        ],
                        "expected": [
                                content().string(containsString("value=\"猫\"")),
                                content().string(containsString("href=\"/search/detail/1\"")),
                                content().string(containsString("<td>夏目漱石</td>")),
                                content().string(containsString("<td>ちくま文庫</td>")),
                        ]
                ]
        ]
        description = testcase.description
    }
}
