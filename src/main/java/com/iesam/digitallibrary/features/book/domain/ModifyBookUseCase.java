package com.iesam.digitallibrary.features.book.domain;

public class ModifyBookUseCase {

        private final BookRepsoitory bookRepsoitory;

        public ModifyBookUseCase(BookRepsoitory bookRepsoitory) {
            this.bookRepsoitory = bookRepsoitory;
        }

        public void execute(Book book){
            bookRepsoitory.delete(book.getISBN());
            bookRepsoitory.save(book);
        }
}
