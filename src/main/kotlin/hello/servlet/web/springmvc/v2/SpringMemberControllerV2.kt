package hello.servlet.web.springmvc.v2

import hello.servlet.domain.member.Member
import hello.servlet.domain.member.MemberRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Controller
@RequestMapping("/springmvc/v2/members")
class SpringMemberControllerV2 {
  private val memberRepository = MemberRepository

  @RequestMapping("/new-form")
  fun newForm(): ModelAndView {
    return ModelAndView("new-form")
  }

  @RequestMapping("/save")
  fun save(request: HttpServletRequest?, response: HttpServletResponse?): ModelAndView {
    val username = request?.getParameter("username") ?: ""
    val age = request?.getParameter("age")?.toInt() ?: 0

    val member = Member(username, age)
    memberRepository.save(member)

    val modelAndView = ModelAndView("save-result")
    modelAndView.addObject("member", member)
    return modelAndView
  }

  @RequestMapping
  fun members(): ModelAndView {
    val members = memberRepository.findAll()
    val modelAndView = ModelAndView("members")
    modelAndView.addObject("members", members)
    return modelAndView
  }
}