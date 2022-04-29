import functions
import graph
import lagrange
import points


def start_ui():
    global set_of_points
    while 1:
        x_input = []
        y_input = []
        choose_mode()
        mode = int(input())
        if (mode == 1):
            points.print_points()
            set_id = int(input())
            if (set_id >= 1 and set_id <= 3):
                    set_of_points = points.get_points(set_id)
            else:
                    print_error("Error! Can't find this table of points!")
                    break

        elif (mode == 2):
            print("Enter x and y separated by space. Enter 'q' to stop input.")
            while 1:
                inp = input()
                input_split = inp.split()
                if (input_split[0] == "q"):
                    break
                x_y = [float(input_split[0]), float(input_split[1])]
                x_input.append(x_y[0])
                y_input.append(x_y[1])
            set_of_points = [x_input, y_input]

        functions.print_functions()
        function_id = int(input())
        if (function_id >= 1 and function_id <= 3):
            lagrange_polynomial = lagrange.create_Lagrange_polynomial(set_of_points)
            functions.get_value_for_function(lagrange_polynomial)
            print("Look at the graph!")
            graph.plot_graph(lagrange_polynomial, set_of_points, function_id)
        else:
            print_error("Error! Can't find this function!")
            break

    return 0


def print_error(text):
    print("\033[31m{}".format(text))
    return 0


def choose_mode():
    print("Choose input mode: " + "\n" +
          "1) Ready-made values for points," + "\n" +
          "2) Console input;")
    return 0
