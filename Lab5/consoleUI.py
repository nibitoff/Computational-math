import sys

import functions
import graph
import runge_kutta


def start_ui():
    while 1:
        functions.print_functions()
        functions_id = is_number(input())
        if (functions_id >= 1 and functions_id <= 3):
            n = enter_amount()
            h = enter_step()
            initial_point = enter_initial_point()
            result_points = runge_kutta.runge_kutta_solve(initial_point, functions_id, h, n)
            print_result(result_points)
            graph.plot_graph(functions_id, result_points)
            print("Look at the graph!")
        else:
            print_error("Error! Can't find this function!")
            break


def enter_amount():
    print("Enter n: ")
    n = int(input())
    return n

def enter_step():
    print("Enter h (step): ")
    h = is_number(input())
    if h <= 0.0:
        print_error("Error! step must be greater than '0'!")
        sys.exit()
    return h


def enter_initial_point():
    print("Enter the initial value of x: ")
    x = is_number(input())
    print("Enter the initial value of y: ")
    y = is_number(input())
    initial_point = [x, y]
    return initial_point

def print_result(points):
    for i in points:
        print("x = {:6.5f}".format(i[0]) +
              " | y = {:6.6f}".format(i[1]))
    return 0

def is_number(s):
    try:
        if float(s) or s.isnumeric():
            return float(s)
        else:
            print_error("Error! Value must be a digit!")
            sys.exit()
    except ValueError:
        print_error("Error! Value must be a digit!")
        sys.exit()


def print_error(text):
    print("\033[31m{}".format(text))
    return 0
