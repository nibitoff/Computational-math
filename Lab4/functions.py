import math

import consoleUI
import lagrange


def print_functions():
    print("Choose function to compare:")
    print("'1' - 3 * x + 5" "\n" +
          "'2' - x^2" + "\n" +
          "'3' - cos(x)")
    return 0


def get_function(number, x):
    if number == 1:
        return (3 * x + 5)
    elif number == 2:
        return (x ** 2)
    elif number == 3:
        return math.cos(x)
    else:
        print("Error! Can't find this function!")
        return 0


def get_value_for_function(lagrange_polynomial):
    while 1:
        print("Do you want to calculate value for this function? 'Y'/'N': ")
        check_calculation = str(input())
        if (check_calculation == "Y"):
            print("Enter x to calculate:")
            x_to_cal = float(input())
            value = lagrange_polynomial(x_to_cal)
            print("f(" + str(x_to_cal) + ") = {:.4f}".format(value))
            return 1
        else:
            return 0
