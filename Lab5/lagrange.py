def create_basic_polynomial(points, i):
    def basic_polynomial(x):
        upper_part = 1
        divider_part = 1
        for j in range (len(points)):
            if j != i:
                upper_part *= (x-points[j][0])
                divider_part *= (points[i][0] - points[j][0])
        return upper_part/divider_part
    return basic_polynomial

def create_Lagrange_polynomial(points):
    basic_polynomials = []
    for i in range (len(points)):
        basic_polynomials.append(create_basic_polynomial(points, i))

    def lagrange_polynomial(x):
        result = 0
        for i in range(len(points)):
            result += points[i][1]*basic_polynomials[i](x)
        return result
    return lagrange_polynomial