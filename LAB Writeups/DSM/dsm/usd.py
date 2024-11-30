import pygame
import sys
import math

# Initialize pygame
pygame.init()

# Set up display
width, height = 800, 600
screen = pygame.display.set_mode((width, height))
pygame.display.set_caption("Euler Circuit and Hamiltonian Path Game")

# Colors
black = (0, 0, 0)
white = (255, 255, 255)
light_blue = (173, 216, 230)  # Light color for initial edges
red = (255, 0, 0)
clicked_color = (0, 255, 0)  # Color when a dot is clicked

# Font settings
font = pygame.font.SysFont(None, 36)

# Shape definitions
def generate_triangle(center, size):
    return [
        (center[0], center[1] - size),  # Top vertex
        (center[0] - size * math.sqrt(3) / 2, center[1] + size / 2),  # Bottom left vertex
        (center[0] + size * math.sqrt(3) / 2, center[1] + size / 2)   # Bottom right vertex
    ]

def generate_square(center, size):
    half_size = size // 2
    return [
        (center[0] - half_size, center[1] - half_size),
        (center[0] + half_size, center[1] - half_size),
        (center[0] + half_size, center[1] + half_size),
        (center[0] - half_size, center[1] + half_size)
    ]

def reset_game(shape_type):
    global dots, connected_edges, connected_dots, dot_colors
    connected_edges = []
    connected_dots = []
    dot_colors = []

    if shape_type == 'triangle':
        dots = generate_triangle((width // 2, height // 2), 100)
    elif shape_type == 'square':
        dots = generate_square((width // 2, height // 2), 200)

    for _ in range(len(dots)):
        dot_colors.append(white)  # Initialize dot colors to white

def is_hamiltonian_path(dots, connected):
    return len(connected) == len(dots) and len(set(connected)) == len(connected)

def is_eulerian_circuit(connected_edges):
    degree_count = {}
    for start, end in connected_edges:
        degree_count[start] = degree_count.get(start, 0) + 1
        degree_count[end] = degree_count.get(end, 0) + 1
    return all(degree % 2 == 0 for degree in degree_count.values()) and len(connected_edges) > 0

# Initial game setup
shape_type = 'triangle'  # Start with a triangle
reset_game(shape_type)

# Game loop
while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            pygame.quit()
            sys.exit()
        if event.type == pygame.MOUSEBUTTONDOWN:
            mouse_pos = event.pos
            clicked_dot = None
            for index, dot in enumerate(dots):
                if pygame.math.Vector2(dot).distance_to(mouse_pos) < 20:
                    clicked_dot = index
                    break

            # Ensure the clicked dot is not already clicked
            if clicked_dot is not None and dot_colors[clicked_dot] == white:
                dot_colors[clicked_dot] = clicked_color  # Change color on click
                if connected_dots:
                    last_dot = connected_dots[-1]
                    # Only allow connection to already clicked dots or the starting dot if it's the first connection
                    if (last_dot == 0 and clicked_dot != 0) or clicked_dot == 0:
                        print("Cannot connect to the starting point until the path is complete!")
                    elif (dots[last_dot], dots[clicked_dot]) not in connected_edges and (dots[clicked_dot], dots[last_dot]) not in connected_edges:
                        connected_edges.append((dots[last_dot], dots[clicked_dot]))
                        connected_dots.append(clicked_dot)
                else:
                    connected_dots.append(clicked_dot)

                # Check for Hamiltonian Path completion
                if is_hamiltonian_path(dots, connected_dots) and connected_dots[-1] == 0:
                    print("Hamiltonian Path Complete!")
                    reset_game('square' if shape_type == 'triangle' else 'triangle')  # Switch shapes for next level

                # Check for Eulerian Circuit completion
                if is_eulerian_circuit(connected_edges) and connected_dots[-1] == 0:
                    print("Eulerian Circuit Complete!")
                    reset_game('square' if shape_type == 'triangle' else 'triangle')  # Switch shapes for next level

    # Fill the screen with black
    screen.fill(black)

    # Draw the dots with their current colors
    for index, dot in enumerate(dots):
        pygame.draw.circle(screen, dot_colors[index], dot, 10)

    # Draw edges in light color
    if len(dots) > 1:
        for i in range(len(dots)):
            for j in range(i + 1, len(dots)):
                if (dots[i], dots[j]) not in connected_edges and (dots[j], dots[i]) not in connected_edges:
                    pygame.draw.line(screen, light_blue, dots[i], dots[j], 2)

    # Draw connected edges in red
    for start, end in connected_edges:
        pygame.draw.line(screen, red, start, end, 5)

    # Display instructions
    instructions = font.render("Click on the dots to connect them.", True, white)
    level_text = font.render(f"Shape: {'Triangle' if shape_type == 'triangle' else 'Square'}", True, white)

    screen.blit(instructions, (20, 20))
    screen.blit(level_text, (20, 60))

    # Update the display
    pygame.display.flip()
    pygame.time.delay(30)
