class OperationsProcessor {

    /** Obtiene la lista de valores numericos de una columna de los valores del
     * mapa con la información de las cotizaciones
     *
     * @param marketInfo - Información de las cotizaciones de mercado
     * @param position - Columna del marketInfo escogida para sacar sus valores
     *
     * @return Valores de la columna escogida
     */
    fun getColumn(marketInfo: Map<String, List<Float>>, position: Int): List<Float> {
        val columnValues = mutableListOf<Float>()
        marketInfo.values.forEach { if (position < it.size) { columnValues.add(it[position]) } }
        return columnValues
    }


    /** Realiza la media de los valores de una columna de las cotizaciones de mercado
     *
     * @param columnInfo - Información de una columna del csv
     *
     * @return Media de los valores de la columna
     */
    fun calculateAverage(columnInfo: List<Float>): Float {
        var summation = 0.0f
        for (number in columnInfo) {
            summation += number
        }

        return summation / columnInfo.size
    }


    /** Calcula el mínimo de los valores de una columna de las cotizaciones de mercado
     *
     * @param columnInfo - Información de una columna del csv
     *
     * @return Mínimo de los valores de la columna
     */
    fun calculateMinimum(columnInfo: List<Float>): Float {
        var minimum = columnInfo[0]
        for (number in columnInfo) {
            if (number < minimum) {
                minimum = number
            }
        }

        return minimum
    }


    /** Calcula el máximo de los valores de una columna de las cotizaciones de mercado
     *
     * @param columnInfo - Información de una columna del csv
     *
     * @return Máximo de los valores de la columna
     */
    fun calculateMaximum(columnInfo: List<Float>): Float {
        var maximum = columnInfo[0]
        for (number in columnInfo) {
            if (number > maximum) {
                maximum = number
            }
        }

        return maximum
    }

}