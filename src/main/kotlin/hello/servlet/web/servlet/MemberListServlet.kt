package hello.servlet.web.servlet

import hello.servlet.domain.member.MemberRepository
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name = "memberListServlet", urlPatterns = ["/servlet/members"])
class MemberListServlet : HttpServlet() {
  // Singleton
  private val memberRepository = MemberRepository

  override fun service(request: HttpServletRequest?, response: HttpServletResponse?) {
    val members = memberRepository.findAll()

    response?.also {
      response.contentType = "text/html"
      response.characterEncoding = "utf-8"
      val writer = response.writer
      writer.write("<html>")
      writer.write("<head>")
      writer.write(" <meta charset=\"UTF-8\">")
      writer.write(" <title>Title</title>")
      writer.write("</head>")
      writer.write("<body>")
      writer.write("<a href=\"/index.html\">메인</a>")
      writer.write("<table>")
      writer.write(" <thead>")
      writer.write(" <th>id</th>")
      writer.write(" <th>username</th>")
      writer.write(" <th>age</th>")
      writer.write(" </thead>")
      writer.write(" <tbody>")
      for (member in members) {
        writer.write(" <tr>")
        writer.write(" <td>" + member.id + "</td>")
        writer.write(" <td>" + member.userName + "</td>")
        writer.write(" <td>" + member.age + "</td>")
        writer.write(" </tr>")
      }

      writer.write(" </tbody>")
      writer.write("</table>")
      writer.write("</body>")
      writer.write("</html>")
    }
  }
}