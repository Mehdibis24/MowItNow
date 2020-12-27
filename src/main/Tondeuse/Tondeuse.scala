package Tondeuse



class Tondeuse(var x: Int, var y: Int , var orientation : Char, val x_border: Int, val y_border: Int){

  def get_position() = s"${x} ${y} ${orientation}"

  def move(command: Char): Unit = {
    command match {
      case 'D' => {
        orientation match {
          case 'E' => orientation = 'S'
          case 'W' => orientation = 'N'
          case 'N' => orientation = 'E'
          case 'S' => orientation = 'W'
        }
      }
      case 'G' => {
        orientation match {
          case 'E' => orientation = 'N'
          case 'W' => orientation = 'S'
          case 'N' => orientation = 'W'
          case 'S' => orientation = 'E'
        }
      }
      case 'A' => {
        orientation match {
          case 'E' =>
            if (x < x_border) x = x + 1
          case 'W' =>
            if (x > 0) x = x -1
          case 'N' =>
            if (y < y_border) y = y + 1
          case 'S' =>
            if (y > 0) y = y - 1
        }
      }
      case default => {
        println("Cette commande n'existe pas, Retapez une autre commande dans (A,D,G)")
        sys.exit()
      }
    }
  }

}

