package net.coolblossom.lycee.app.web.service

import net.coolblossom.lycee.app.web.repository.BookRepository
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification
import spock.lang.Unroll


@SpringBootTest
@AutoConfigureMockMvc
@Unroll
class BookServiceSpec extends Specification {

    MockMvc mockMvc

    @Autowired
    WebApplicationContext appContext


    @Autowired
    BookService bookService

    @SpringBean
    BookRepository bookRepositoryMock = Mock()

    def setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(appContext).build()
    }

    @Unroll
    def "test BookService#select #description" () {
        given:
            bookRepositoryMock.findByBookNameLike(_ as String) >> testCase.repository
        when:
            def actual = bookService.select(testCase.keyword)
        then:
            assert actual.size() == testCase.expectedList.size()

        where:
        testCase << [
                [
                        'description': "キーワードがNULLのとき",
                        'keyword': null,
                        'repository': Collections.emptyList(),
                        'expectedList': Collections.emptyList()
                ]
        ]

        description = testCase.description
    }



}
