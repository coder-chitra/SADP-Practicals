
<!DOCTYPE html>
<html>
<head>
    <title>MVC Calculator</title>
</head>
<body>
    <h2>MVC Calculator</h2>

    <form action="calculate" method="post">
        First Number:
        <input type="number" step="any"
               name="num1" required>
        <br><br>

        Second Number:
        <input type="number" step="any"
               name="num2" required>
        <br><br>

        Operation:
        <select name="operation">
            <option value="add">Addition (+)</option>
            <option value="subtract">Subtraction (-)</option>
            <option value="multiply">Multiplication (*)</option>
            <option value="divide">Division (/)</option>
        </select>
        <br><br>

        <button type="submit">Calculate</button>
    </form>

    <h3>Result: ${result}</h3>
    <p style="color:red">${error}</p>
</body>
</html>
