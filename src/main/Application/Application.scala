package Application
import io.Source.fromResource
import Tondeuse.Tondeuse

object Application {
  def lire_commandes(nom_fichier : String): Unit ={
    var x_border = 0
    var y_border = 0
    for(line <- fromResource(s"$nom_fichier").getLines.take(1)){
      val lin2 = line.split(" ")
      x_border = lin2(0).toInt
      y_border = lin2(1).toInt
    }


    val fileLines = fromResource(s"$nom_fichier").getLines.drop(1)
    var a = 1
    var tondeuse = new Tondeuse(x = 0, y = 0, orientation = 'N', x_border = x_border, y_border = y_border)
    for( line <- fileLines) {

      if (a%2 !=0) {
        var x_y_orientation = line.split(" ")

        tondeuse.x = x_y_orientation(0).toInt
        tondeuse.y = x_y_orientation(1).toInt
        tondeuse.orientation = x_y_orientation(2).charAt(0)
      }
      else {
        val commandes = line.toList

        commandes.foreach(tondeuse.move(_))

        val position_finale = tondeuse.get_position()

        println(s"Tondeuse ${a / 2} : ${position_finale}")
      }

      a = a+1
    }

  }
}
