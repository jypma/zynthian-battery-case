package nl.ypmania.zynthian

import scadla.Cube
import scadla.Cylinder
import scadla.InlineOps._
import scadla.backends.OpenSCAD

object Case extends App {
  
  object Cover {
    val width = 89.0
    val height = 65.0
    val holeExtR = 5.0
    
    val holeExt = Cylinder(holeExtR, 3)
    val hole = Cylinder(1.75, 3.2).moveZ(-0.1)
    
    val connSpace = Cube(36, 30, 3.2).moveZ(-0.1).moveX(44).moveY(4)
    
    val shape = Cube(width, height, 3) +
                holeExt.moveX(holeExtR) +
                holeExt.moveX(width - holeExtR) +
                holeExt.moveX(holeExtR).moveY(height) +
                holeExt.moveX(width - holeExtR).moveY(height) -
                hole.moveX(holeExtR) -
                hole.moveX(width - holeExtR) -
                hole.moveX(holeExtR).moveY(height) -
                hole.moveX(width - holeExtR).moveY(height) -
                connSpace
                
  }
  
  OpenSCAD.toSCAD(Cover.shape, "screenCover")
  OpenSCAD.toSTL(Cover.shape, "screenCover.stl")
  
}