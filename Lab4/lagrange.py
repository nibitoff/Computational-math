def create_basic_polynomial(x_values, i):
    def basic_polynomial(x):
        divider = 1
        result = 1
        for j in range(len(x_values)):
            if j != i:
                result *= (x - x_values[j])
                divider *= (x_values[i] - x_values[j])
        return result / divider

    return basic_polynomial


def create_Lagrange_polynomial(points):
    basic_polynomials = []
    for i in range(len(points[0])):
        basic_polynomials.append(create_basic_polynomial(points[0], i))

    def lagrange_polynomial(x):
        result = 0
        for i in range(len(points[1])):
            result += points[1][i] * basic_polynomials[i](x)
        return result

    return lagrange_polynomial
