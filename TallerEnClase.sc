// Sacar la correleacion de pearson

var tabla = List( (72, 115),
                  (76, 121),
                  (78, 125),
                  (81, 130),
                  (89, 141),
                  (95, 150),
                  (108, 165),
                  (115, 170),
                  (120, 177),
                  (130, 178))

var numItemsX = (tabla: List[(Int, Int)] ) => tabla.map( _._1 ).length
var numItemsY = (tabla: List[(Int, Int)] ) => tabla.map( _._2 ).length

// val calcxMedia = ( table : List [ (Int, Int) ] ) : Double => table.map(x => x._1 * x._2).sum.toFloat / calcN(table)
//  Sumatoria Xs
var sumatoriaXs = (tabla: List[(Int, Int)] ) => tabla.map(x => x._1).sum
// Sumatoria Ys
var sumatoriaYs = (tabla: List[(Int, Int)] ) => tabla.map(x => x._2).sum

// producto de x & y (su sumatoria)
var sumatoriaXporY = (tabla: List[(Int, Int)] ) => tabla.map(x => x._1 * x._2).sum
//  cuadrados de x    (su sumatoria)
var sumatoriaCuadradosX = (tabla: List[(Int, Int)] ) => tabla.map(x => Math.pow(x._1, 2) ).sum
//  cuadrados de y    (su sumatoria)
var sumatoriaCuadradosY = (tabla: List[(Int, Int)] ) => tabla.map(x => Math.pow(x._2, 2) ).sum

// media marginal Xs = SumatoriaXs / # items - .toFloat para no perder precisión
var mediaMarginalX = sumatoriaXs(tabla).toFloat / numItemsX(tabla)
// media marginal Ys = SumatoriaYs / # items
var mediaMarginalY = sumatoriaYs(tabla).toFloat / numItemsY(tabla)
// Desviación típica marginal de X
var desvTipMargX = Math.sqrt( sumatoriaCuadradosX(tabla) / numItemsX(tabla) - Math.pow(mediaMarginalX, 2) )
// Desviación típica marginal de Y
var desvTipMargY = Math.sqrt( sumatoriaCuadradosY(tabla) / numItemsY(tabla) - Math.pow(mediaMarginalY, 2) )

var covarianza = sumatoriaXporY(tabla) / numItemsX(tabla) - mediaMarginalX * mediaMarginalY
var coeficienteFinal = covarianza / ( desvTipMargX * desvTipMargY )