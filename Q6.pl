start(s1).
final(s1).

transition(s1, a, s2).
transition(s2, a, s2).
transition(s2, b, s1).
transition(s2, c, s4).
transition(s4, d, s3).
transition(s3, b, s4).
transition(s3, a, s1).

accept(Inputs) :- start(S), connection(S, Inputs).
connection(S, [H|T]) :- transition(S, H, Sn), connection(Sn, T).
connection(S, []) :- final(S).
