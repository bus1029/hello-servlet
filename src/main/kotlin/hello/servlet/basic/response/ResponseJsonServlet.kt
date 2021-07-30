package hello.servlet.basic.response

import com.fasterxml.jackson.databind.ObjectMapper
import hello.servlet.basic.request.HelloData
import javax.servlet.annotation.WebServlet
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "responseJsonServlet", urlPatterns = ["/response-json"])
class ResponseJsonServlet : HttpServlet() {
  private val objectMapper = ObjectMapper()

  override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
    resp?.also {
      // Content-Type: application/json
      resp.contentType = "application/json"
      resp.characterEncoding = "utf-8"

      val helloData = HelloData("kim", 20)
      // {"username" = "kim", "age" = 20}
      val writeValueAsString = objectMapper.writeValueAsString(helloData)
      resp.writer.write(writeValueAsString)
    }
  }
}