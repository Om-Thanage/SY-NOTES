import matplotlib.pyplot as plt
from matplotlib_venn import venn2, venn3


def draw_venn_diagram(setA, setB, setA_label='Group A', setB_label='Group B', top_performer=None):
    """Draw a Venn diagram for two sets and show top performer."""
    plt.figure(figsize=(8, 6))
    venn2([setA, setB], (setA_label, setB_label))

    # Display top performer in the title
    title = f'Venn Diagram of {setA_label} and {setB_label}'
    if top_performer:
        title += f'\nTop Performer: {top_performer}'

    plt.title(title)
    plt.show()


def draw_venn_diagram_three(setA, setB, setC, setA_label='Group A', setB_label='Group B', setC_label='Group C',
                            top_performer=None):
    """Draw a Venn diagram for three sets and show top performer."""
    plt.figure(figsize=(8, 6))
    venn3([setA, setB, setC], (setA_label, setB_label, setC_label))

    # Display top performer in the title
    title = f'Venn Diagram of {setA_label}, {setB_label}, and {setC_label}'
    if top_performer:
        title += f'\nTop Performer: {top_performer}'

    plt.title(title)
    plt.show()


def find_top_performer(players):
    """Return the top performer based on criteria, e.g., alphabetical order for simplicity."""
    if players:
        return sorted(players)[0]  # Example: return the alphabetically first player
    return None


def main():
    # Example sets for player performance
    players_above_50 = {'Alice', 'Bob', 'Charlie', 'David'}
    players_with_boundaries = {'Bob', 'Charlie', 'Eve', 'Frank'}

    # Find top performers
    top_performer_above_50 = find_top_performer(players_above_50)
    top_performer_boundaries = find_top_performer(players_with_boundaries)

    # Venn Diagram for Players Above 50 Runs and Players with Boundaries
    draw_venn_diagram(players_above_50, players_with_boundaries, 'Above 50 Runs', 'Boundaries Hit',
                      top_performer=top_performer_above_50)

    # Example sets for match outcomes
    matches_won_team_A = {'Match 1', 'Match 2', 'Match 4'}
    matches_won_team_B = {'Match 3', 'Match 4', 'Match 5'}

    # Find top matches won
    top_match_team_A = find_top_performer(matches_won_team_A)
    top_match_team_B = find_top_performer(matches_won_team_B)

    # Venn Diagram for Match Outcomes
    draw_venn_diagram(matches_won_team_A, matches_won_team_B, 'Team A Wins', 'Team B Wins',
                      top_performer=top_match_team_A)

    # Example sets for three groups of players
    players_batsmen = {'Alice', 'Charlie', 'Frank'}
    players_bowlers = {'Bob', 'Eve', 'Grace'}
    players_all_rounders = {'Charlie', 'David', 'Eve'}

    # Find top performers among roles
    top_performer_batsmen = find_top_performer(players_batsmen)
    top_performer_bowlers = find_top_performer(players_bowlers)
    top_performer_all_rounders = find_top_performer(players_all_rounders)

    # Venn Diagram for Player Roles
    draw_venn_diagram_three(players_batsmen, players_bowlers, players_all_rounders,
                            'Batsmen', 'Bowlers', 'All-rounders',
                            top_performer=top_performer_batsmen)


if __name__ == '__main__':
    main()
