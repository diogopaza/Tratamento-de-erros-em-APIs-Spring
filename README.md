Tratamento-de-erros-em-APIs-Spring-55555
Stashed changes

<h2>Controller Advice</h2>
<p>Intercepta todas as exceções que foram geradas a partir de um endpoint da aplicação e se tiver algum método escutando essa exceção, ele será executado.</p>
<p>A anotação <em>@ControllerAdvice</em> é uma especialização de <em>@Component</em> e nos permite definir alguns métodos comuns para vários controllers.</p>

<li>
    <ul>Ter um lugar único de tratamento de erros</ul>
    <ul>Deefinir um corpo de resposta padrão para erros da aplicação</ul>
    <ul>Definir uma estratégia de logs para a aplicação</ul>
    <ul>Definir status de resposta mais adequado</ul>
</li>
