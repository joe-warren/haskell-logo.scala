import cats.syntax.all.*
import cats.effect.unsafe.implicits.global
import doodle.core.*
import doodle.syntax.all.*
import doodle.java2d.*

object HaskellLogo {

  val scaleFac = 100

  val color1 = Color.fromHex("#453a62")
  val color2 = Color.fromHex("#5e5086")
  val color3 = Color.fromHex("#8f4e8b")
  val logo: Picture[Unit] =
    List(
      ClosedPath.empty
        .moveTo(0, 12)
        .lineTo(4, 6)
        .lineTo(0, 0)
        .lineTo(3, 0)
        .lineTo(7, 6)
        .lineTo(3, 12)
        .path
        .fillColor(color1)
        .noStroke,
      ClosedPath.empty
        .moveTo(4, 0)
        .lineTo(8, 6)
        .lineTo(4, 12)
        .lineTo(7, 12)
        .lineTo(15, 0)
        .lineTo(12, 0)
        .lineTo(9.5, 3.75)
        .lineTo(7, 0)
        .path
        .fillColor(color2)
        .noStroke,
      ClosedPath.empty
        .moveTo(13.66, 3.5)
        .lineTo(12.333, 5.5)
        .lineTo(17, 5.5)
        .lineTo(17, 3.5)
        .path
        .fillColor(color3)
        .noStroke,
      ClosedPath.empty
        .moveTo(11.666, 6.5)
        .lineTo(10.333, 8.5)
        .lineTo(17, 8.5)
        .lineTo(17, 6.5)
        .path
        .fillColor(color3)
        .noStroke
    ).reduce(_.on(_))

  @main def haskellLogoMain(): Unit = {
    import doodle.core.format.*

    val picture = logo.scale(scaleFac, scaleFac)
    picture.draw()
    picture.write[Png]("haskell-logo.png")
  }
}
