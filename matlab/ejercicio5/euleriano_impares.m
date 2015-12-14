% Levanto archivos
M = csvread('goloso_eu_impares.csv');
M = M(:, [1,2]); % N MEAN_TIME
goloso_n = M(:,1);
goloso_t = M(:,2);

M = csvread('backtracking_eu_impares.csv');
M = M(:, [1,2 ]); % I CONF MEAN_TIME
b_n = M(:,1);
b_t = M(:,2);

n = vertcat(goloso_n, b_n);
t = vertcat(goloso_t, b_t);

G = vertcat(ones(length(goloso_n), 1),  ones(length(b_t),1)*2);


gscatter(n, t,G);
hold on;
%set(gca, 'XTick', iMyciel)
title('Tiempo de ejecución de grafos eulerianos con ciclos impares según cantidad de nodos.')
legend('Goloso', 'Backtracking');
xlabel('Cantidad de vertices');
ylabel('Milisegundos');
%set(ax,'YScale','log');
