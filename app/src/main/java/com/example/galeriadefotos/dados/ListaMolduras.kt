package com.example.galeria.dados

import com.example.galeriadefotos.R
import com.example.galeriadefotos.model.IdImagemDescricao

class ListaMolduras {
    fun carregarListaMolduras():List<IdImagemDescricao> {
        return listOf<IdImagemDescricao>(
            IdImagemDescricao(R.drawable.imagem1,R.string.descricao_imagem1),
            IdImagemDescricao(R.drawable.imagem2,R.string.descricao_imagem2),
            IdImagemDescricao(R.drawable.imagem3,R.string.descricao_imagem3)
        )
    }

}