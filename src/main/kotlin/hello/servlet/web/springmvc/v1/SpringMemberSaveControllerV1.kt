package hello.servlet.web.springmvc.v1

import hello.servlet.domain.member.Member
import hello.servlet.domain.member.MemberRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Controller
class SpringMemberSaveControllerV1 {
  private val memberRepository = MemberRepository

  @RequestMapping("/springmvc/v1/members/save")
  fun process(request: HttpServletRequest?, response: HttpServletResponse?): ModelAndView {
    val username = request?.getParameter("username") ?: ""
    val age = request?.getParameter("age")?.toInt() ?: 0

    val member = Member(username, age)
    memberRepository.save(member)

    val modelAndView = ModelAndView("save-result")
    modelAndView.addObject("member", member)
    return modelAndView
  }
}