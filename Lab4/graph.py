import matplotlib.pyplot as plt
import numpy as np
import lagrange
import functions

def scan_x_for_minmax(points):
    max = 0.0
    min = 0.0
    x_points_to_check = list(points[0])
    for i in x_points_to_check:
        if i > max:
            max = i
        if i < min:
            min = i

    return [min, max]

def plot_graph(polynom, points, function):
    plt.title("Lagrange polynomial interpolation")
    minmax = scan_x_for_minmax(points)
    min = minmax[0]
    max = minmax[1]
    x = np.linspace(min, max, 10000)
    y = []
    for i in x:
        y.append(polynom(i))

    plt.plot(x, y, color='red', zorder=2, label='polynom', linewidth=2)

    function_x_points = x
    function_y_points = []
    for i in function_x_points:
        function_y_points.append(functions.get_function(function, i))

    function_label = "function (" + str(function) + ")"
    plt.plot(function_x_points, function_y_points, '--', color = 'green', zorder = 4, label = function_label)

    x_points = []
    y_points = []
    for i in range(len(points[0])):
        x_points.append(points[0][i])
        y_points.append(points[1][i])
    plt.scatter(x_points, y_points, color='blue', zorder=3, label='points')
    plt.legend(loc='lower right')
    plt.minorticks_on()
    plt.grid(which='major',
            color='k')

    plt.grid(which='minor',
            color='k',
            linestyle=':')
    plt.show()
