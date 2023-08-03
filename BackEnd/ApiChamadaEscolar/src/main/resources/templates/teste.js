            <select id="dropbox">
                <option value="teste1">Teste 1</option>
                <option value="Teste2">Teste 2</option>
            </select>
            <div id="resultado"></div>
                <script>
                    function mostarSelecao(){
                        const dropbox = document.getElementById('dropbox');
                        const selectedOption = dropbox.option[dropbox.selectedIndex].value
                        document.getElementById('resultado').innerText = "Selecionado: " + selectedOption;
                    }
                </script>

                        <select id="dropbox">
                            <option th:value="${turma.id}">Teste</option>
                        </select>
