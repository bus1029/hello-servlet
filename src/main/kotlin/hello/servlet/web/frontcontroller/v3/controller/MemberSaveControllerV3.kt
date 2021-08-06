package hello.servlet.web.frontcontroller.v3.controller

import hello.servlet.domain.member.Member
import hello.servlet.domain.member.MemberRepository
import hello.servlet.web.frontcontroller.ModelView
import hello.servlet.web.frontcontroller.v3.ControllerV3

class MemberSaveControllerV3 : ControllerV3 {
  private val memberRepository = MemberRepository

  override fun process(paramMap: Map<String, String>): ModelView {
    val userName = paramMap["username"] ?: ""
    val age = paramMap["age"]?.toInt() ?: 0

    val member = Member(userName, age)
    memberRepository.save(member)

    val modelView = ModelView("save-result")
    modelView.model["member"] = member
    return modelView
  }
}