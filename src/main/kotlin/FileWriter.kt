import java.io.BufferedWriter
import java.nio.file.Files
import java.nio.file.Path

class FileWriter {

    private val operationsProcessor = OperationsProcessor()


    /** Escribe un archivo csv con la media, el mínimo y el máximo valor de cada columna del mapa de información
     *  de mercado
     *
     * @param marketInfo - Información del mercado mapeada
     * @param resultPath - Ruta donde se guarda el archivo csv
     */
    fun writeMarketCalculations(marketInfo: Map<String, List<Float>>, resultPath: Path) {

        val bw: BufferedWriter = Files.newBufferedWriter(resultPath)
        val columns = marketInfo.values.first().size

        bw.use { thread ->
            thread.write("Average;Minimum;Maximum\n")
            for (column in 0 until columns) {
                val columnInfo = operationsProcessor.getColumn(marketInfo, column)
                thread.write("${operationsProcessor.calculateAverage(columnInfo)};")
                thread.write("${operationsProcessor.calculateMinimum(columnInfo)};")
                thread.write("${operationsProcessor.calculateMaximum(columnInfo)}\n")
            }
        }

    }

}