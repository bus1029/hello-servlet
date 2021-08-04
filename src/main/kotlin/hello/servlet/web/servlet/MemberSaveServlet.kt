package hello.servlet.web.servlet

import hello.servlet.domain.member.Member
import hello.servlet.domain.member.MemberRepository
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "memberSaveServlet", urlPatterns = ["/servlet/members/save"])
class MemberSaveServlet : HttpServlet() {
  // Singleton
  private val memberRepository = MemberRepository

  override fun service(request: HttpServletRequest?, response: HttpServletResponse?) {
    val member = request?.let {
      val userName = request.getParameter("username")
      val age = request.getParameter("age").toInt()

      val member = Member(userName, age)
      memberRepository.save(member)
      member
    }

    response?.also {
      response.contentType = "text/html"
      response.characterEncoding = "utf-8"
      val writer = response.writer
      writer.write("<html>\n" +
              "<head>\n" +
              " <meta charset=\"UTF-8\">\n" +
              "</head>\n" +
              "<body>\n" +
              "성공\n" +
              "<ul>\n" +
              " <li>id="+ (member?.id ?: 0) +"</li>\n" +
              " <li>username="+ (member?.userName ?: "") +"</li>\n" +
              " <li>age="+ (member?.age ?: 0) +"</li>\n" +
              "</ul>\n" +
              "<a href=\"/index.html\">메인</a>\n" +
              "</body>\n" +
              "</html>");
    }
  }
}