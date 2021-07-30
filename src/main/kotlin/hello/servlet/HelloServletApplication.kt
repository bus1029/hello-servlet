package hello.servlet

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.ServletComponentScan

@ServletComponentScan
@SpringBootApplication
class HelloServletApplication

fun main(args: Array<String>) {
	runApplication<HelloServletApplication>(*args)
}
