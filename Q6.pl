start(s1).                  % Start at S1
final(s1).                  % Accept also at S1

transition(s1, a, s2).      % Transition: (s1) --a--> (s2)
transition(s2, a, s2).      % Transition: (s2) --a--> (s2)
transition(s2, b, s1).
transition(s2, c, s4).
transition(s4, d, s3).
transition(s3, b, s4).
transition(s3, a, s1).

accept(Inputs) :- start(S), connection(S, Inputs).                  % Accepted if Inputs start at S & having some connections between S and Inputs
connection(S, [H|T]) :- transition(S, H, Sn), connection(Sn, T).    % Go through each elements in the list, check transitions, do recursive calls
connection(S, []) :- final(S).                                      % Once the whole is is consumed, check if we're at the Final state.
