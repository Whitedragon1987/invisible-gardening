import com.invisiblegardening.Exceptions.RecordNotFoundException;
import com.invisiblegardening.Models.Quote;
import com.invisiblegardening.repositories.QuoteRepository;
import com.invisiblegardening.services.QuoteServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class QuoteServiceTest {

    @Mock
    QuoteRepository quoteRepository;

    @InjectMocks
    private QuoteServiceImpl quoteService;

    @Captor
    ArgumentCaptor<Quote> quoteCaptor;

    @Test
    public void getQuoteTest() {
        Quote quote = new Quote();
        quote.setId(1L);
        when(quoteRepository.findById(1L)).thenReturn(Optional.of(quote));

        var quote1 =quoteService.getQuote(1L);
        assertThat(quote1.getId()).isEqualTo(1L);
    }

    @Test
    public void getQuoteExceptionTest() {
        assertThrows(RecordNotFoundException.class, () -> quoteService.getQuote(null));
    }

    @Test
    public void getQuoteListTest() {
        List<Quote> testQuotes = new ArrayList<>();
        Quote quote1 = new Quote();
        quote1.setId(1L);

        Quote quote2 = new Quote();
        quote2.setId(2L);

        Quote quote3 = new Quote();
        quote3.setId(3L);


        testQuotes.add(quote1);
        testQuotes.add(quote2);
        testQuotes.add(quote3);

        when(quoteRepository.findAll()).thenReturn(testQuotes);

        quoteService.getQuoteList();

        verify(quoteRepository, times(1)).findAll();

        assertThat(testQuotes.size()).isEqualTo(3);
        assertThat(testQuotes.get(0)).isEqualTo(quote1);
        assertThat(testQuotes.get(1)).isEqualTo(quote2);
        assertThat(testQuotes.get(2)).isEqualTo(quote3);
    }

    @Test
    public void saveQuoteTest() {
        Quote quote = new Quote();
        quote.setId(1L);

        quoteRepository.save(quote);

        verify(quoteRepository, times(1)).save(quoteCaptor.capture());
        var quote1 = quoteCaptor.getValue();

        assertThat(quote1.getId()).isEqualTo(1L);
    }

    @Test
    public void deleteQuoteTest() {
        Quote quote1 = new Quote();
        quote1.setId(1L);
        quote1.setQuoteDescription("test");

        quoteRepository.delete(quote1);

        quoteService.deleteQuote(1L);

        verify(quoteRepository, times(1)).delete(quote1);
    }

    @Test
    public void uploadSituationTest() {

    }
}