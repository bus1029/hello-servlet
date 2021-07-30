package hello.servlet.basic.request

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.util.StreamUtils
import java.nio.charset.StandardCharsets
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = ["/request-body-json"])
class RequestBodyJsonServlet : HttpServlet() {
  private val objectMapper = ObjectMapper()

  override fun service(req: HttpServletRequest?, resp: HttpServletResponse?) {
    val messageBody = req?.let {
      val inputStream = req.inputStream
      val messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8)
      println("messageBody = $messageBody")
      val helloData = objectMapper.readValue(messageBody, HelloData::class.java)
      println("helloData username = ${helloData.username}")
      println("helloData age = ${helloData.age}")
      messageBody
    }

    resp?.also {
      resp.writer.write("$messageBody OK")
    }
  }
}