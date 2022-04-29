import matplotlib.pyplot as plt
import numpy as np
import lagrange
import functions

def scan_x_for_minmax(points):
    max = points[0][0]
    min = points[0][1]

    for i in points:
        if i[0] > max:
            max = i[0]
        if i[0] < min:
            min = i[0]

    return [min, max]

def plot_graph(function, points):
    plt.title("Runge–Kutta method differential equation solver")
    minmax = scan_x_for_minmax(points)
    min = minmax[0]
    max = minmax[1]
    lagrange_polynomial = lagrange.create_Lagrange_polynomial(points)
    x = np.linspace(min, max, 1000)
    y = []
    for i in x:
        y.append(lagrange_polynomial(i))

    plt.plot(x, y, color='red', zorder=2, label='polynomial', linewidth=2)

    function_x_points = x
    function_y_points = []
    c = functions.calculate_C(function, points[0][0], points[0][1])
    for i in function_x_points:
        function_y_points.append(functions.get_derivative_of_function(function, i, c))

    function_label = "function (№" + str(int(function)) + ")"
    plt.plot(function_x_points, function_y_points, '--', color = 'green', zorder = 4, label = function_label)

    x_points = []
    y_points = []
    plt.scatter(points[0][0], points[0][1], color='purple', zorder=5, label='initial point')
    for i in range(1, len(points)):
        x_points.append(points[i][0])
        y_points.append(points[i][1])
    plt.scatter(x_points, y_points, color='blue', zorder=3, label='points')
    plt.legend(loc='lower right')
    plt.minorticks_on()
    plt.grid(which='major',
            color='k')

    plt.grid(which='minor',
            color='k',
            linestyle=':')
    plt.show()
