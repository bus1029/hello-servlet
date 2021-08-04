package hello.servlet.domain.member

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

class MemberRepositoryTest {
  private val memberRepository = MemberRepository

  @AfterEach
  fun destroy() {
    memberRepository.clearStore()
  }

  @Test
  fun save() {
    val member = Member("hello", 20)
    val savedMember = memberRepository.save(member)
    val findById = memberRepository.findById(savedMember.id)
    assertThat(findById).isEqualTo(savedMember)
  }

  @Test
  fun findAll() {
    val member = Member("member1", 20)
    val member1 = Member("member2", 30)

    memberRepository.save(member)
    memberRepository.save(member1)

    val members = memberRepository.findAll()

    assertThat(members.size).isEqualTo(2)
    assertThat(members).contains(member, member1)
  }
}