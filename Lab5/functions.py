import math


def print_functions():
    print("Choose equation to solve:")
    print("1) y' = -2 * y " + "\n" +
          "2) y' = y * (x^2 + 1)" + "\n" +
          "3) y' = sin(x) + y")
    return 0


def get_function(number, x, y):
    if number == 1:
        return (- 2 * y)
    elif number == 2:
        return y * (x ** 2 + 1)
    elif number == 3:
        return math.sin(x) + y
    else:
        print("Error! Can't find this function!")
    return 0


def get_derivative_of_function(number, x, C):
    if number == 1:
        return C * math.exp(-2 * x)
    elif number == 2:
        return C * math.exp((x ** 3) / 3 + x)
    elif number == 3:
        return ((-math.sin(x)/2) - (math.cos(x)/2) + C*math.exp(x))
    return 0


def calculate_C(number, x, y):
    if number == 1:
        return y / math.exp(-2 * x)
    elif number == 2:
        return y / math.exp((x ** 3) / 3 + x)
    elif number == 3:
        return (y+(math.sin(x)/2)+(math.cos(x)/2))/math.exp(x)
