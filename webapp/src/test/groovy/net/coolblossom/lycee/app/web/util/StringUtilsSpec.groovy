package net.coolblossom.lycee.app.web.util

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class StringUtilsSpec extends Specification {

    @Unroll
    def "test isEmpty #descr" () {

        when:
            def result = StringUtils.isEmpty(testcase.source)

        then:
            result == testcase.expected

        where:
        testcase << [
                [
                        'descr': 'null値',
                        'source': null,
                        'expected': true,
                ],
                [
                        'descr': '空文字列',
                        'source': '',
                        'expected': true,
                ],
                [
                        'descr': '半角スペース',
                        'source': ' ',
                        'expected': false,
                ],
                [
                        'descr': '全角スペース',
                        'source': '　',
                        'expected': false,
                ],
                [
                        'descr': 'カタカナ',
                        'source': 'アイウエオ',
                        'expected': false,
                ],
        ]
        descr = testcase.descr
    }




}
