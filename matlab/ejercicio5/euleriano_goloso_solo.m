% Levanto archivos
M = csvread('goloso_eu_solo.csv');
M = M(:, [1,2]); % N MEAN_TIME
goloso_n = M(:,1);
goloso_t = M(:,2);

n = goloso_n%vertcat(goloso_n, b_n);
t = goloso_t%vertcat(goloso_t, b_t);

%G = vertcat(ones(length(goloso_n), 1),  ones(length(b_t),1)*2);


scatter(n, t);
hold on;
%set(gca, 'XTick', iMyciel)
title('Tiempo de ejecución de grafos eulerianos con ciclos impares según cantidad de nodos.')
legend('Goloso');
xlabel('Cantidad de vertices');
ylabel('Milisegundos');
%set(ax,'YScale','log');
