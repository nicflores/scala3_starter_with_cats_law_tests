package com.pbtwd

import com.pbtwd.domain.User

import cats.Order
import cats.kernel.laws.discipline.OrderTests
import org.scalatest.funsuite.AnyFunSuite
import org.scalacheck.Arbitrary
import org.scalacheck.Gen
import org.typelevel.discipline.scalatest.FunSuiteDiscipline
import org.scalatestplus.scalacheck.Checkers

class UserSpec extends AnyFunSuite with FunSuiteDiscipline with Checkers {

  given userOrdering: Ordering[User] = Ordering.by(_.age)
  // given catsUserOrder: Order[User] = Order.fromOrdering(userOrdering)

  given UserArb: Arbitrary[User] = Arbitrary {
    for {
      name <- Gen.alphaStr
      age <- Gen.chooseNum(0, 120)
    } yield User(name, age)
  }

  given UserFuncArb: Arbitrary[User => User] = Arbitrary {
    for {
      user1 <- UserArb.arbitrary
      user2 <- UserArb.arbitrary
    } yield user1 => user2
  }

  checkAll(
    "test User satisfies order properties",
    OrderTests[User].order
  )
}
