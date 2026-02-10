import java.math.BigDecimal

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val transaction = Transaction("1", BigDecimal(10.02))

    println(transaction)
    println(transaction.hashCode())
    println(transaction.equals(transaction.copy(id = "2")))
    println(transaction.equals(Transaction("1", BigDecimal(10.02))))
}