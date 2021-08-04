package hello.servlet.domain.member

object MemberRepository {
  private val store = HashMap<Long, Member>()
  private var sequence: Long = 0

  fun save(member: Member): Member {
    member.id = ++sequence
    store[member.id] = member
    return member
  }

  fun findById(id: Long): Member? {
    return store[id]
  }

  fun findAll(): List<Member> {
    return store.values.toList()
  }

  fun clearStore() {
    store.clear()
  }
}