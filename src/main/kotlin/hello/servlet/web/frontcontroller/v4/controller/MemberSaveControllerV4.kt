package hello.servlet.web.frontcontroller.v4.controller

import hello.servlet.domain.member.Member
import hello.servlet.domain.member.MemberRepository
import hello.servlet.web.frontcontroller.v4.ControllerV4

class MemberSaveControllerV4 : ControllerV4 {
  private val memberRepository = MemberRepository

  override fun process(paramMap: Map<String, String>, model: HashMap<String, Any?>): String {
    val userName = paramMap["username"] ?: ""
    val age = paramMap["age"]?.toInt() ?: 0
    val member = Member(userName, age)
    memberRepository.save(member)

    model["member"] = member
    return "save-result"
  }
}