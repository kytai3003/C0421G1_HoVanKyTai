// happy coding 👻
function fibonaccySum(num) {
    if (num <= 2) {
        return 1;
    }
    return fibonaccySum(num - 1) + fibonaccySum(num - 2);
}
var sum = 0;
for (var i = 1; i < 15; i++) {
    console.log(fibonaccySum(i));
    if (fibonaccySum(i)) {
        sum += fibonaccySum(i);
    }
}
console.log("Tổng của 13 số fibonaccy đầu tiên là: " + sum);
