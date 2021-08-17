package hello.servlet.web.springmvc.v3

import hello.servlet.domain.member.Member
import hello.servlet.domain.member.MemberRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/springmvc/v3/members")
class SpringMemberControllerV3 {
  private val memberRepository = MemberRepository

//  @RequestMapping("/new-form", method = [RequestMethod.GET])
  @GetMapping("/new-form")
  fun newForm(): String {
    return "new-form"
  }

//  @RequestMapping("/save", method = [RequestMethod.POST])
  @PostMapping("/save")
  fun save(@RequestParam("username") username: String, @RequestParam("age") age: Int, model: Model): String {
    val member = Member(username, age)
    memberRepository.save(member)
    model.addAttribute("member", member)
    return "save-result"
  }

//  @RequestMapping(method = [RequestMethod.GET])
  @GetMapping
  fun members(model: Model): String {
    val members = memberRepository.findAll()
    model.addAttribute("members", members)
    return "members"
  }
}