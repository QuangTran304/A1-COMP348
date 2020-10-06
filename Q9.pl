lucas(0, [2]).
lucas(1, [2,1]).

lucas(N, F):- 
        N>1,
        N1 is N-1,
        N2 is N-2,
        lucas(N1, F1),
        lucas(N2, F2),
        last(F1, L1),
        last(F2, L2),
        L3 is L1 + L2, 
        append(F1, [L3], F).