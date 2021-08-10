package hello.servlet.web.frontcontroller.v4

import java.io.IOException
import javax.servlet.ServletException

interface ControllerV4 {
  @Throws(ServletException::class, IOException::class)
  fun process(paramMap: Map<String, String>, model: HashMap<String, Any?>): String
}