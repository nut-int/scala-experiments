package example

import org.scalacheck.Gen
import org.specs2.ScalaCheck
import org.specs2.mutable._


class SpceMath extends Specification with Tables with ScalaCheck {

	"power function" >> {
		"a" | "b" | "c" |
		 2  !  2  !  4  |
		 -3	!  3  !  -27  |
		 -0  !  0  !  1  |> { (a, b, c) => DotoMath.power(a, b) must_== c }
	}

	"power function any power of 2 " >> {
		prop { (a:Int) => (a < 0) ==> {
				DotoMath.power(a, 2) must be_>=(0.0)
			}
		}
		.set(minTestsOk = 500, workers = 3)
		.setGen(Gen.chooseNum(-500, 0))
	}
}