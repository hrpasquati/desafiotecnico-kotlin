package model

fun main() {

    var investimoInicialJoao: Double = 100.00
    //Variável responsável em armazenar o tempo de investimento em semanas
    var tempoSemanas: Int = 36
    val taxaSelic: Double = 4.25
    //Variável responsável por armazenar a conversão do tempo de investimento de semanas para dias
    var tempoRendimentoDias: Int = tempoRendimento(tempoSemanas)
    //Váriavel responsável por armazenar o rendimento
    var rendimento = "%.2f".format(
        calculoRentabilidade(
            investimoInicialJoao,
            taxaSelic,
            tempoRendimentoDias.toDouble(),
            tempoSemanas
        )
    )
    //Váriavel responsável por armazenar o rendimento ganho após um determidado tempo de investimento
    var diferencaValorTotalPeloInvestimento = "%.2f".format(
        diferencaValorInvestidoPeloTotal(
            investimoInicialJoao,
            taxaSelic,
            tempoRendimentoDias.toDouble(),
            tempoSemanas
        )
    )

    println("Com a ajuda da Grão, João terá um total de R$$rendimento em $tempoSemanas semanas. Seu rendimento final é de R$$diferencaValorTotalPeloInvestimento")


}

//Função responsável por fazer o cálculo da rentabilidade
fun calculoRentabilidade(
    investimoInicialJoao: Double,
    taxaSelic: Double,
    tempoRendimentoDias: Double,
    tempoSemanas: Int
): Double {
    return (investimoInicialJoao * tempoSemanas) * Math.pow((1 + (taxaSelic / 100)), tempoRendimentoDias / 252)
}

//Função responsável por converter o tempo de investimento de semanas para dias
fun tempoRendimento(tempoSemanas: Int): Int {
    return ((tempoSemanas / 4) * 252) / 12
}

//Função responsável por cálcular o rendimento ganho
fun diferencaValorInvestidoPeloTotal(
    investimoInicialJoao: Double,
    taxaSelic: Double,
    tempoRendimentoDias: Double,
    tempoSemanas: Int
): Double {
    return calculoRentabilidade(
        investimoInicialJoao,
        taxaSelic,
        tempoRendimentoDias,
        tempoSemanas
    ) - (investimoInicialJoao * tempoSemanas)
}

