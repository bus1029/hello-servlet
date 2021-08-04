package hello.servlet.web.servlet

import hello.servlet.domain.member.MemberRepository
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "memberFormServlet", urlPatterns = ["/servlet/members/new-form"])
class MemberFormServlet : HttpServlet() {
  // Singleton
  private val memberRepository = MemberRepository

  override fun service(request: HttpServletRequest?, response: HttpServletResponse?) {
    response?.also {
      response.contentType = "text/html"
      response.characterEncoding = "utf-8"

      val writer = response.writer
      writer.write("<!DOCTYPE html>\n" +
              "<html>\n" +
              "<head>\n" +
              " <meta charset=\"UTF-8\">\n" +
              " <title>Title</title>\n" +
              "</head>\n" +
              "<body>\n" +
              "<form action=\"/servlet/members/save\" method=\"post\">\n" +
              " username: <input type=\"text\" name=\"username\" />\n" +
              " age: <input type=\"text\" name=\"age\" />\n" +
              " <button type=\"submit\">전송</button>\n" +
              "</form>\n" +
              "</body>\n" +
              "</html>\n")
    }
  }
}