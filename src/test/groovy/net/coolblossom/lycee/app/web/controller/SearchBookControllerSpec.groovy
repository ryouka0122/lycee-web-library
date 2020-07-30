package net.coolblossom.lycee.app.web.controller

import net.coolblossom.lycee.app.web.config.JpaConfig
import net.coolblossom.lycee.app.web.config.ThymeleafConfig
import net.coolblossom.lycee.app.web.config.WebConfig
import net.coolblossom.lycee.app.web.repository.BookRepository
import net.coolblossom.lycee.app.web.service.BookService
import net.coolblossom.lycee.app.web.service.impl.BookServiceImpl
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification
import spock.lang.Unroll


@AutoConfigureMockMvc
@SpringBootTest
@Unroll
class SearchBookControllerSpec extends Specification {

    @Autowired
    MockMvc mockMvc

    @Autowired
    WebApplicationContext appContext

    @SpringBean
    BookRepository bookRepositoryMock = Mock()

    def setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(appContext).build()
    }

    @Unroll
    def "test" () {
        given:
            bookRepositoryMock.findByBookNameLike(_ as String) >> Collections.emptyList()
        when:
            def result = mockMvc.perform(MockMvcRequestBuilders.get("/search"))

        then:
            result.andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().contentType("text/html;charset=UTF-8"))

    }
}
