import sys

import functions
import graph
import runge_kutta


def start_ui():
    while 1:
        functions.print_functions()
        functions_id = is_number(input())
        if (functions_id >= 1 and functions_id <= 3):
            borders = enter_borders()
            h = enter_step()
            initial_point = enter_initial_point()
            result_points = runge_kutta.runge_kutta_solve(initial_point, functions_id, h, borders)
            print_result(result_points)
            graph.plot_graph(functions_id, result_points)
            print("Look at the graph!")
        else:
            print_error("Error! Can't find this function!")
            break


def enter_borders():
    borders = []
    print("Enter left border: ")
    a = is_number(input())
    print("Enter right border: ")
    b = is_number(input())
    if b <= a:
        print_error("Error! Right border must be greater than left border!")
        sys.exit()
    borders = [a, b]
    return borders


def enter_step():
    print("Enter h (step): ")
    h = is_number(input())
    if h <= 0.0:
        print_error("Error! step must be greater than '0'!")
        sys.exit()
    return h


def enter_initial_point():
    print("Enter the initial value of y: ")
    y = is_number(input())
    return y

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
