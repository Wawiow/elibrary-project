import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.elibraryproject.data.repository.BookRepository

import com.example.elibraryproject.viewmodel.BookViewModel

class BookViewModelFactory(
    private val repo: BookRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return BookViewModel(repo) as T
    }
}
