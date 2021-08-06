package hello.servlet.web.frontcontroller.v3.controller

import hello.servlet.domain.member.Member
import hello.servlet.domain.member.MemberRepository
import hello.servlet.web.frontcontroller.ModelView
import hello.servlet.web.frontcontroller.MyView
import hello.servlet.web.frontcontroller.v1.ControllerV1
import hello.servlet.web.frontcontroller.v2.ControllerV2
import hello.servlet.web.frontcontroller.v3.ControllerV3
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class MemberListControllerV3 : ControllerV3 {
  private val memberRepository = MemberRepository

  override fun process(paramMap: Map<String, String>): ModelView {
    val members = memberRepository.findAll()
    val modelView = ModelView("members")
    modelView.model["members"] = members
    return modelView
  }
}